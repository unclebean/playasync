(defproject playasync "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.3.442"]
                 [http-kit "2.2.0"]
                 [clj-rome "0.4.0"]]
  :main ^:skip-aot playasync.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
