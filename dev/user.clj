;; This namespace is normally not committed, but is included here for example
;; keg-party.clients.rest-client is included as part of the :markbastian/dev
;; profile, along with the client dependency. Now, when I launch the project
;; REPL I am auto-tapped in.
;;
;; I also need to configure my environment with some combination of the
;; following env variables
;;
;; KEG_PARTY_USERNAME=username
;; KEG_PARTY_PASSWORD=password
;; KEG_PARTY_PORT=3333
;;
;; KEG_PARTY_USERNAME=username
;; KEG_PARTY_PASSWORD=password
;; KEG_PARTY_HOST=https://keg-party.loca.lt
(ns user
  (:require
    [keg-party.clients.rest-client :as kprc]))

(kprc/tap-in!)
(tap> "TAPPING IN!!!!")
(println "You are tapped in!!!")
