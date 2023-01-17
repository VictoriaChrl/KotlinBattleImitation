class Stack<T> {
    open var stack = mutableListOf<T>()

    fun push(item: T) {
        stack.add(item)
    }

    fun pop(): T? {
        return if (stack.size == 0) {
            return null
        } else stack.removeAt(stack.size - 1)
    }


    open fun isEmpty(): Boolean {
        return stack.isEmpty()
    }


}