(ns playasync.core
  (:require [clojure.core.async :as async
             :refer [>! <! >!! <!! go chan buffer close! alts!! go-loop merge]]
            [playasync.http-call :as http-call]
            [clojure.java.io :as io]
            )
  (:gen-class))

(defn -main
  [feeds-path & args]
  (with-open [feeds-io (io/reader feeds-path)]
    (let [ch (chan)
          feeds (line-seq feeds-io)]
      (doall
        (map (fn [url] (http-call/get-rss-v2 ch url)) feeds)
        )
        (go-loop []
          (<! ch)
          (recur))
      )
    ;(let [feeds (line-seq feeds-io)]
    ;  (doall
    ;    (for [feed feeds]
    ;      (go (<! (http-call/get-rss feed)))
    ;      )
    ;    )
    ;)
  ))




