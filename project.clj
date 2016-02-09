(defproject student-synk "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.0.0"]
                 [tentacles "0.5.1"]
                 [environ "1.0.2"]]
  :plugins [[lein-environ "1.0.2"]]
  :main ^:skip-aot student-synk.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
