(ns clojure-meeting-asami.core
  (:require [asami.core :as a]
            [naga.store :as store]
            [naga.store-registry :as r]))


(def store (r/get-storage-handle {:type :memory}))

(let [id1 (store/new-node store)
      id2 (store/new-node store)]

  ;; No entities like DS  
  (def datoms [[id1 :name "Bob"]
               [id1 :age 30]
               [id2 :name "Sally"]
               [id2 :age 15]]))

(def db (store/assert-data store datoms))

(def q-young '[:find ?n
               :in $ ?min-age
               :where
               [?e :name ?n]
               [?e :age ?a]
               [(< ?a ?min-age)]])

(a/q q-young db 18)
