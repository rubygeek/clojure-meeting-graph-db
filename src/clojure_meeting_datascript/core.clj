(ns clojure-meeting-datascript.core
  (:require [datascript.core :as d]
            [datascript.db :as db])
  (:gen-class))


(def schema { :person/name {:db/cardinality :db.cardinality/one
                            :db/valueType   :db.type/string
                            :db/doc         "A person's name"}
             
              :person/age  {:db/cardinality :db.cardinality/one
                            :db/valueType   :db.type/string
                            :db/doc         "A person's age"}})

;; created with no schema
;; (def conn (d/create-conn))


(def conn (d/create-conn schema))

;; Define entities to transact
(def entities [{:db/id -1 :name "Bob" :age 30}
               {:db/id -2 :name "Sally" :age 15}])

;;; Add the entities via transaction
(d/transact! conn entities)

;; datoms via transaction
(d/transact! conn [{:db/id -3 :name "george"}])
(d/transact! conn [{:db/id -4 :name "mary"}])
(d/transact! conn [{:db/id -4 :age "13"}])

conn


;; Query to find names for entities (people) whose age is less than 18
(def q-young '[:find ?n
               :in $ ?min-age
               :where
               [?e :name ?n]
               [?e :age ?a]
               [(< ?a ?min-age)]])

;; execute query: q-young, passing 18 as min-age
(d/q q-young @conn 18)



