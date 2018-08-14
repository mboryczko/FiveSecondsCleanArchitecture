package pl.michal_boryczko.data.util


/**
 * A functional interface which allow transform object itself to another type.
 *
 * @param R the output value type
 */
interface Transformer<out R> {

	/**
	 *  Apply some calculation on object itself, then return some other value.
	 */

	fun transform(): R
}