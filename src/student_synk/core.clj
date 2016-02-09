(ns student-synk.core
  (:require [tentacles.orgs :as orgs]
            [environ.core :refer [env]])
  (:gen-class))

(defn gh-teams
  [org]
  (orgs/teams org {:auth (str (env :github-username) ":" (env :github-password))}))

(defn cohort-team?
  [team]
  (re-matches
   #"\w+-\d{4}(-cohort)*"
   (get team :slug)))

(defn -main
  "Collects Makers Academy cohorts and students from Github"
  [& args]
  (filter cohort-team?
           (gh-teams "makersacademy")))
