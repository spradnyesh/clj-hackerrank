// https://app.codility.com/c/run/UMSSZN-3V6

// please note that my programming paradigm is functional (clojure/clojurescript) and that codility does not support any functional languages
// the methodology of solving any problem in functional versus procedural style is completely different

function solution(A) {
    count = 1;
    sorted = JSON.stringify(A.slice().sort());
    for (var i = 1, len = A.length; i < len; i++) {
        left = A.slice(0, i);
        right = A.slice(i, len);
        if (JSON.stringify(left.slice().sort().concat(right.slice().sort())) == sorted) {
            count = count + solution(right);
        }
    }
    return count;
};

// function solution_1(A) {
//     var arrs = [];
//     arrs[0] = [A[0]];
//     for (var i = 1, len = A.length, index = 0; i < len; i++) {
//         if (!(A[i] < A[i - 1])) {
//             index++;
//             arrs[index] = [];
//         }
//         arrs[index].push(A[i]);
//     }
//     console.log(arrs);
// }

// function solution_0(A) {
//     var count = 0;
//     for (var i = 0, len = A.length - 1; i < len; i++) {
//         if (A[i] < A[i + 1]) {
//             count++;
//         }
//     }
//     return count;
// }

console.log(solution([2, 4, 1, 6, 5, 9, 7]));
console.log(solution([4, 3, 2, 6, 1]));
console.log(solution([2, 1, 6, 4, 3, 7]));
