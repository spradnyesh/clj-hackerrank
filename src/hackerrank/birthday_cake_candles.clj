(ns hackerrank.birthday-cake-candles)

;; https://www.hackerrank.com/challenges/birthday-cake-candles/problem

(defn birthdayCakeCandles [n ar]
  (->> ar
       frequencies
       (sort-by first)
       reverse
       first
       last))

;; (def fptr (get (System/getenv) "OUTPUT_PATH"))
;; (def n (Integer/parseInt (clojure.string/trim (read-line))))
;; (def ar (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))
;; (def result (birthdayCakeCandles n ar))
;; (spit fptr (str result "\n") :append true)
