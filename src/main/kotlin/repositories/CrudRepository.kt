package repositories

interface CrudRepository<T, ID> {
    fun findAll(): Array<T>
    fun findById(id: ID): T?
    fun create(item: T): T
    fun update(id: ID, item: T): T?
    fun delete(id: ID): T?
}