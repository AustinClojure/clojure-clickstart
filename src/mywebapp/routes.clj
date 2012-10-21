(ns mywebapp.routes
  (:use compojure.core
        mywebapp.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [cemerick.drawbridge]))

(defroutes app-routes
  (GET "/" [] (index-page))
  (GET "/about" [] (about-page))
  (route/resources "/"))


(if-let [secret (System/getProperty "replsecret")]
  (defroutes repl-routes
    (ANY "/repl/:guess" [guess :as request] 
         (if (= secret guess)
           ((cemerick.drawbridge/ring-handler) request)
           (route/not-found "secret does not match replsecret"))))
  
  (defroutes repl-routes
    (ANY "/repl/:guess" [] 
         (route/not-found "replsecret not set. use bees config:set {account/appname} replsecret={SECRET}"))))


(defroutes all-routes
  app-routes
  repl-routes
  (route/not-found "No page"))

(def app
  (handler/site all-routes))
