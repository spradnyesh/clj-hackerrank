(ns hackerrank.time-conversion)

;; https://www.hackerrank.com/challenges/time-conversion/problem

(defn timeConversion [s]
  (let [join clojure.string/join
        time (join "" (take 8 s))
        ampm (join "" (drop 8 s))
        [hh mm ss] (clojure.string/split time #":")]
    (if (= "AM" ampm)
      (if (= hh "12")
        (join ":" ["00" mm ss])
        time)
      (if (= hh "12")
        time
        (join ":" [(+ (Integer/parseInt hh) 12) mm ss])))))

;; (def fptr (get (System/getenv) "OUTPUT_PATH"))
;; (def s (read-line))
;; (def result (timeConversion s))
;; (spit fptr (str result "\n") :append true)
