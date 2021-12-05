
function minusOneInternal(x) {
    return x - 1
}

// Exposes functions 
module.exports = {
    addOne: function (x) {
        return x + 1
    },
    minusOne: function(x) {
        // It is possible to use internal functions without exposing those functions. 
        return minusOneInternal(x)
    }
};
