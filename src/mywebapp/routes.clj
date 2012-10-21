(ns mywebapp.routes
  (:use compojure.core
        mywebapp.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [cemerick.drawbridge]))

(defroutes app-routes
  (GET "/" [] (index-page))
  (GET "/about" [] (about-page))
  (route/resources "/")  

  (if-let [secret (System/getProperty "magicword")]
    
    (let [nrepl-handler (cemerick.drawbridge/ring-handler)]
      (ANY (str "/repl/" secret) request (nrepl-handler request)))
    
    (route/not-found "No page"))
  
  (route/not-found "No page"))


(def app
  (handler/site app-routes))
