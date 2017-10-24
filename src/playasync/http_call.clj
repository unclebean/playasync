(ns playasync.http-call
  (:require
    [clojure.core.async :as async
     :refer [>! <! >!! <!! go chan buffer close! alts!! put!]]
    [org.httpkit.client :as http])
  )


(defn get-rss
  [url]
    (let [ch (chan)]
      (http/get url
        (fn [response]
          (if (= 200 (:status response))
            (go (>! ch response))
            )
          ))
      ch
      )
  )

(defn get-rss-v2
  [ch url]
  (http/get url
            (fn [response]
              (if (= 200 (:status response))
                (put! ch response)
                )
              )))
