(ns hackerrank.encryption)

;; https://www.hackerrank.com/challenges/encryption/problem

(def sentence "if man was meant to stay on the ground god would have given us roots")

(defn encrypt [sentence]
  (let [line (clojure.string/replace sentence #" " "")
        find-row-column (fn [n]
                          (let [sqrt (Math/sqrt n)
                                row (Math/floor sqrt)
                                col (Math/ceil sqrt)]
                            (when (>= (* row col))
                              (mapv int [row col]))))
        [row col] (find-row-column (count line))]
    (clojure.string/join #" " (apply mapv (fn [& args]
                                            (->> args
                                                 (clojure.string/join "")
                                                 clojure.string/trimr))
                                     (partition col col (repeat " ") line)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; boilerplate already provided
(let [s (read-line)
      fptr (get (System/getenv) "OUTPUT_PATH")
      result (encrypt s)]
  (spit fptr (str result "\n") :append true))
