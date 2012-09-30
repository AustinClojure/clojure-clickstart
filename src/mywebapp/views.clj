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
       [:li.active [:a {:href "/about"} "About"]]]]]]])

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
   
   [:div {:class "hero-unit"}
    [:h1 "Clojure on Cloudbees"]
    [:p "Welcome to the Clojure Clickstart!"]
    [:p
     [:a {:class "btn btn-primary btn-large"
          :href "http://wiki.cloudbees.com/bin/view/Main/"}
      "Get help with Cloudbees."]]]))

(defn about-page []
  (template
   [:div {:class "well"}
    [:h1 "About"]
    [:p "This Clojure clickstart was developed by members of the "
     [:a {:href "http://www.meetup.com/Austin-Clojure-Meetup/"} "Austin Clojure Meetup"]
     ".  You can find us as "
     [:a {:href "https://github.com/AustinClojure"} "AustinClojure on github"]
     "."]]))
