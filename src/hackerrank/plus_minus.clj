(ns hackerrank.plus-minus)

;; https://www.hackerrank.com/challenges/plus-minus/problem

(defn plusMinus [arr]
  (let [cnt (count arr)
        f #(float (/ (count (filter % arr)) cnt))]
    [(f pos?) (f neg?) (f zero?)]))

;; (def n (Integer/parseInt (clojure.string/trim (read-line))))

;; (def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

;; (def result (plusMinus arr))

;; (def fptr (get (System/getenv) "OUTPUT_PATH"))
;; (spit fptr (clojure.string/join "\n" result) :append true)
