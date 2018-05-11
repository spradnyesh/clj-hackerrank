(ns hackerrank.grading-students)

;; https://www.hackerrank.com/challenges/grading/problem

(defn gradingStudents [grades]
  (let [round (fn [n]
                (if (or (< n 38)
                        (< (rem n 5) 3))
                  n
                  (* (inc (quot n 5)) 5)))]
    (mapv round grades)))

;; (def fptr (get (System/getenv) "OUTPUT_PATH"))
;; (def n (Integer/parseInt (clojure.string/trim (read-line))))
;; (def grades [])
;; (doseq [_ (range n)]
;;   (def grades (conj grades (Integer/parseInt (read-line)))))
;; (def result (gradingStudents grades))
;; (spit fptr (clojure.string/join "\n" result) :append true)
;; (spit fptr "\n" :append true)
