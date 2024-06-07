(ns markbastian.keg-party-demo
  (:require
    [malli.core :as m]
    [malli.generator :as mg]))

;; To follow along...
;; 1. Take a look at dev/user.clj
;; 2. Configure your env and run this project

(def address
  (m/schema
    [:map
     [:id [:string {:min 1 :max 8}]]
     [:tags [:set keyword?]]
     [:address
      [:map
       [:street string?]
       [:city string?]
       [:zip int?]
       [:lonlat [:tuple double? double?]]]]]))

(comment
  (doseq [a (mg/sample address)]
    (tap> a))

  ;; A code form
  (tap>
    '(defn start!
       ([config]
        (alter-var-root #'*system* (fn [s] (if-not s (ig/init config) s))))
       ([] (start! config))))

  ;; A matrix
  (tap> (vec (repeatedly 10 #(vec (repeatedly 10 (fn [] (rand-int 10)))))))

  ;; A tall tap
  (tap> (into {} (for [i (range 100)]
                   [(keyword (str "key-" i)) i])))

  ;; A wide tap
  (tap> (apply str (repeat 1000 "X")))
  )
