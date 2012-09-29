(ns mywebapp.views
  (:use [hiccup core page]))

(defn header []
  [:div.navbar.navbar-inverse.navbar-fixed-top
   [:div.navbar-inner
    [:div.container
     [:a.brand {:href "/"} "Cloudbees Clickstart"]
     [:div.nav-collapse.collapse
      [:ul.nav
       [:li.active [:a {:href "/"} "Home"]]
       [:li.active [:a {:href "/second-page"} "Page Two"]]]]]]])

(defn template [& body]
  (html5
   [:head
    [:title "Cloudbees clickstart"]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    (include-css "/css/bootstrap.min.css")]
   [:body {:style "padding-top:60px;"}
    (header)
    [:div.container
     body]]))

(defn index-page []
  (template
   [:h2 "Index"]
   [:p "Using " [:b "ring"] "/" [:b "compojure"] "/" [:b "hiccup"]]
   [:div [:a {:href "http://wiki.cloudbees.com/bin/view/Main/"} "Get help with Cloudbees."]]))

(defn second-page []
  (template
   [:h2 "Page Two"]))
