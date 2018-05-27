// https://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/

var recursive = function (n, v, i) {
    if (n < 0) {
        return 0;
    }
    if (n == 0) {
        return 1;
    }
    // means coins over and n > 0, so no solution
    if (i == v.length && n > 0) {
        return 0;
    }
    return recursive(n - v[i], v, i) + recursive(n, v, i + 1);
};

var dynamic = function(amount, v) {
    // create solution matrix
    var solution = [];
    for (var i = 0; i < v.length + 1; i++) {
        solution[i] = [];
    }
    // if amount = 0, then just return empty set (1 way)
    for (i = 0; i < v.length + 1; i++) {
        solution[i][0] = 1;
    }
    // if no coins given, then 0 ways to change amount
    for (i = 0; i < amount + 1; i++) {
        solution[0][i] = 0;
    }
    // now fill rest of the matrix
    for (i = 1; i < v.length + 1; i++) {
        for (j = 1; j < amount + 1; j++) {
            // check if the coin value is less than amount needed
            if (v[i - 1] <= j) {
                // reduce amount by coin value and
                // use subproblem solution (amount - v[i]) and
                // add solution from top to it
                solution[i][j] = solution[i - 1][j] + solution[i][j - v[i - 1]];
            } else {
                // just copy value from the top
                solution[i][j] = solution[i - 1][j];
            }
        }
    }
    return solution[v.length][amount];
};

var amount = 10;
var v = [2, 5, 3, 6];
console.log(new Date());
console.log("by dynamic: " + dynamic(amount, v));
console.log(new Date());
console.log("by recursion: " + recursive(amount, v, 0));
console.log(new Date());
