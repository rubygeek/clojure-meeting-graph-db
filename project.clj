(defproject clojure-meeting-datascript "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [datascript "0.18.2"]
                 [org.clojars.quoll/asami "0.2.17"]
                 [org.clojars.quoll/naga-store "0.3.0"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
