(ns hackerrank.extra-long-factorials
  (use [clojure.string :only (split triml)]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; https://www.hackerrank.com/challenges/extra-long-factorials/problem
(defn fact [n]
  (reduce *' (range 1 (inc (bigint n)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; boilerplate already provided
(
   let [
        n_t (read-line)
        n (Integer/parseInt n_t)
        fptr (get (System/getenv) "OUTPUT_PATH")
        result (fact n)]
   (spit fptr (str result "\n") :append true)
   )
