(ns mywebapp.repl)

(defn get-secret []
  (System/getProperty "replsecret"))

(defn test-secret [guess]
  (= guess (get-secret)))

;; test that the secret exists (set and isn't empty
(defn secret-set? []
  (pos? (count (get-secret))))




