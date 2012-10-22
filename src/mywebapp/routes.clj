(ns mywebapp.routes
  (:use compojure.core
        mywebapp.views
        mywebapp.repl)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [cemerick.drawbridge]))

(defroutes app-routes
  (GET "/" [] (index-page))
  (GET "/repl" [] (repl-page))
  (GET "/about" [] (about-page))
  (route/resources "/"))


(defn repl-handler [request guess]
  (if (secret-set?)
    (if (test-secret guess)
      ((cemerick.drawbridge/ring-handler) request)
      (route/not-found "secret does not match replsecret"))
    
    (route/not-found "replsecret not set. use bees config:set {account/appname} replsecret={SECRET}")))

(defroutes repl-routes
  (ANY "/repl/:guess" [guess :as request] 
       (repl-handler request guess)))

(defroutes all-routes
  app-routes
  repl-routes
  (route/not-found "No page"))

(def app
  (handler/site all-routes))
