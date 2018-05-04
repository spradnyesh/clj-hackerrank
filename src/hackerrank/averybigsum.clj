(ns hackerrank.averybigsum)

;; https://www.hackerrank.com/challenges/a-very-big-sum/problem
(defn aVeryBigSum [n ar]
  (reduce + ar))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; boilerplate already provided
(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def ar (vec (map #(Long/parseLong %) (clojure.string/split (read-line) #" "))))

(def result (aVeryBigSum n ar))

(spit fptr (str result "\n") :append true)
