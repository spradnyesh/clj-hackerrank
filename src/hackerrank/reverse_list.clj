(ns hackerrank.reverse-list)

;; https://www.hackerrank.com/challenges/fp-reverse-a-list/problem

(fn reverse-list [lst]
  (let [f (fn [arr acc]
            (if (empty? arr)
              acc
              (recur (rest arr) (conj acc (first arr)))))]
    (f lst ())))
