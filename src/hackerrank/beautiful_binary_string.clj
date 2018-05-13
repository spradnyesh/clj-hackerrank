(ns hackerrank.beautiful-binary-string)

;; https://www.hackerrank.com/challenges/beautiful-binary-string/problem

(defn beautifulBinaryString [b]
  (count (re-seq #"010" b)))

;; (def fptr (get (System/getenv) "OUTPUT_PATH"))

;; (def n (Integer/parseInt (clojure.string/trim (read-line))))

;; (def b (read-line))

;; (def result (beautifulBinaryString b))

;; (spit fptr (str result "\n") :append true)
