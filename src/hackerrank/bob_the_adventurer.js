// please note that my programming paradigm is functional (clojure/clojurescript) and that codility does not support any functional languages
// the methodology of solving any problem in functional versus procedural style is completely different

function solution(A) {
    var slopes = [], quadrant, x, y, count = 0;
    for (var i = 0, len = A.length; i < len; i++) {
        x = A[i][0]; y = A[i][1];
        if (x >= 0 && y >= 0) {
            quadrant = 1;
        } else if (x >= 0 && y < 0) {
            quadrant = 2;
        } else if (x < 0 && y >= 0) {
            quadrant = 3;
        } else { // if (x < 0 && y < 0)
            quadrant = 4;
        }
        slopes.push([(A[i][1] / A[i][0]), quadrant]);
    }
    console.log(slopes.sort());
    for (i = 0, len = slopes.length; i < len - 1; i++) {
        if (JSON.stringify(slopes[i]) != JSON.stringify(slopes[i + 1])) {
            count++;
        }
    }
    return count + 1;
}

console.log(solution([[-1, -2], [1, 2], [2, 4], [-3, 2], [2, -2]]));
