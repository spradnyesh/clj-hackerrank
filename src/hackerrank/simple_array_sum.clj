(ns hackerrank.simple-array-sum)

;; https://www.hackerrank.com/challenges/simple-array-sum/problem

(defn simpleArraySum [ar]
  (reduce + ar))

;; (def fptr (get (System/getenv) "OUTPUT_PATH"))

;; (def ar-count (Integer/parseInt (clojure.string/trim (read-line))))

;; (def ar (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

;; (def result (simpleArraySum ar))

;; (spit fptr (str result "\n") :append true)
