fun main() {
    val helper = PaginationHelper<Char>(listOf('a', 'b', 'c', 'd', 'e', 'f'), 4)
    println(helper.pageCount) //should == 2
    println(helper.itemCount) //should == 6
//    println(helper.pageItemCount(0) )//should == 4
//    println(helper.pageItemCount(1) )// last page - should == 2
    println(helper.pageItemCount(2))// should == -1 since the page is invalid

    // pageIndex takes an item index and returns the page that it belongs on
    println(helper.pageIndex(5))//should == 1 (zero based index)
    println(helper.pageIndex(2))//should == 0
    println(helper.pageIndex(20))//should == -1
    println(helper.pageIndex(-10)) //should == -1

}

class PaginationHelper<T>(val collection: List<T>, val itemsPerPage: Int) {

    /**
     * returns the number of items within the entire collection
     */
    val itemCount: Int
        get() {
            return collection.size
        }

    /**
     * returns the number of pages
     */
    val pageCount: Int
        get() {
            val r = collection.size / itemsPerPage
            return if (collection.size % itemsPerPage == 0) {
                r
            } else r + 1
        }


    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    fun pageItemCount(pageIndex: Int): Int {
        return if (pageIndex > pageCount - 1 || pageIndex < 0) {
            -1
        } else if (pageIndex == pageCount - 1) {
            collection.size % itemsPerPage
        } else itemsPerPage
    }


    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    fun pageIndex(itemIndex: Int): Int {
        val r = (itemIndex + 1) / itemsPerPage
        return if (itemIndex > (itemCount - 1) || itemIndex < 0) {
            -1
        } else if ((itemIndex + 1) % itemsPerPage == 0) {
            r-1
        } else r
    }


    val itemCount1 = collection.size

    val pageCount1 = Math.ceil(itemCount.toDouble() / itemsPerPage.toDouble()).toInt()

    fun pageItemCount1(pageIndex: Int) = when {
        pageIndex < 0 -> -1
        pageIndex >= pageCount -> -1
        pageIndex == pageCount - 1 -> itemCount % itemsPerPage
        else -> itemsPerPage
    }

    fun pageIndex1(itemIndex: Int) = when {
        itemIndex < 0 -> -1
        itemIndex >= itemCount -> -1
        else -> itemIndex / itemsPerPage
    }
}