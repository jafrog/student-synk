(ns student-synk.core-test
  (:require [clojure.test :refer :all]
            [student-synk.core :refer :all]
            [tentacles.orgs :as orgs]))

(defn mock-teams
  [org &opts]
  '({:slug "april-2015-cohort"
     :name "April 2015"
     :members-url "https://api.github.com/teams/1/members{/member}"}
    {:slug "not-a-cohort"}))

(with-redefs-fn {#'orgs/teams mock-teams}
  #(deftest import-cohorts-students
     (testing "-main returns all cohorts with students"
       (let [results (-main)]
         (is (= "april-2015-cohort" (get (first results) :slug)))
         (is (not
              (some #{"not-a-cohort"} (map (fn [cohort] (get cohort :slug)) results))))))))
