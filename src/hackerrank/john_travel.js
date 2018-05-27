// please note that my programming paradigm is functional (clojure/clojurescript) and that codility does not support any functional languages
// the methodology of solving any problem in functional versus procedural style is completely different

function solution(A, B, C) {
    var rslts = [];
    for (var i = 0, lenA = A.length; i < lenA; i++) {
        for (var j = 0, lenB = B.length; j < lenB; j++) {
            for (var k = 0, lenC = C.length; k < lenC; k++) {
                if (A[i] < B[j] && B[j] < C[k]) {
                    rslts.push([A[i], B[j], C[k]]);
                }
            }
        }
    }
    return rslts.length;
}

console.log(solution([29, 50], [61, 37], [37, 70]));
console.log(solution([29, 29], [61, 61], [70, 70]));
console.log(solution([5], [5], [5]));
