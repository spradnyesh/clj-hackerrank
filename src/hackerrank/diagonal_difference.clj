(ns hackerrank.diagonal-difference)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; https://www.hackerrank.com/challenges/diagonal-difference/problem
(defn diagonalDifference [a]
  (let [size (count (first a))
        get-element (fn [a i j] (nth (nth a i) j))
        f (fn [primary?]
            (reduce +
                    (for [i (range size)
                          j (range size)
                          :when (if primary?
                                  (= i j)
                                  (= (dec size) (+ i j)))]
                      (get-element a i j))))
        primary (f true)
        secondary (f false)]
    (Math/abs (- primary secondary))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; boilerplate already provided
(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def a [])

(doseq [_ (range n)]
  (def a (conj a (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))))

(def result (diagonalDifference a))

;; (spit fptr (str result "\n") :append true)
