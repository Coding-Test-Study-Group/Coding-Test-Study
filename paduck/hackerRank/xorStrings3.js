process.stdin.on("end", function () {
    // now we can read/parse input
    const strings_xor=(s, t)=>{
        return s^t
    }
    const [s,t] = input.split("\n");
    console.log(strings_xor(s,t))
});