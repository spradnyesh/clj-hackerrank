(ns hackerrank.kangaroo)

;; https://www.hackerrank.com/challenges/kangaroo/problem

(defn kangaroo [x1 v1 x2 v2]
  (let [f (fn [a1 v1 a2 v2 cntr]
            (cond (zero? cntr) "NO"
                  (= (+ a1 v1) (+ a2 v2)) "YES"
                  :else (recur (+ a1 v1) v1 (+ a2 v2) v2 (dec cntr))))]
    (f x1 v1 x2 v2 10000)))

;; (def result (kangaroo x1 v1 x2 v2))
;; (def fptr (get (System/getenv) "OUTPUT_PATH"))
;; (spit fptr result :append true)
;; (spit fptr "\n" :append true)
