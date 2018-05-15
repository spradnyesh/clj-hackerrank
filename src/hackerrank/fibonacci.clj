(ns hackerrank.fibonacci)

;; https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers/problem

(defn fib [n]
  (if (< n 2)
    n
    (+ (fib (dec n)) (fib (- n 2)))))

((fn f [n] (println (fib (dec n)))) (Integer/parseInt (read-line)))
