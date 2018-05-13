(ns hackerrank.alternating-characters)

;; https://www.hackerrank.com/challenges/alternating-characters/problem

(defn alternatingCharacters [s]
  (let [f (fn [arr prev cnt]
            (cond (empty? arr) cnt
                  (= prev (first arr)) (recur (rest arr) prev (inc cnt))
                  :else (recur (rest arr) (first arr) cnt)))]
    (f s "" 0)))

;; (def fptr (get (System/getenv) "OUTPUT_PATH"))

;; (def q (Integer/parseInt (clojure.string/trim (read-line))))

;; (doseq [q-itr (range q)]
;;   (def s (read-line))

;;   (def result (alternatingCharacters s))

;;   (spit fptr (str result "\n") :append true)
;;   )
