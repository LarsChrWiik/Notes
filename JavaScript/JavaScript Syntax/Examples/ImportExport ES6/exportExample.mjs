
function minusOneInternal(x) {
    return x - 1
}

function addOne(x) {
    return x + 1
}

function minusOne(x) {
    // It is possible to use internal functions. 
    return minusOneInternal(x)
}

export function anotherFunction() {
    // We cna export functions like this as well. 
}


// We can have only ONE "default" export per file. 
export {
    addOne, 
    minusOne
}
