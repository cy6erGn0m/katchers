/*
 * Copyright 2012 Daniel Seidler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.katchers

/**
 * @author Daniel Seidler
 * @since 2012/11/21
 */

// Any must
public fun <T>T.must(val verb: BE): AnyBeMatcher<T> = AnyBeMatcher(this)
public fun <T>T.must(val verb: NOTBE): AnyNotBeMatcher<T> = AnyNotBeMatcher(this)
public fun <T>T.must(val verb: MATCH): AnyMatchMatcher<T> = AnyMatchMatcher(this)
public fun <T>T.must(val verb: NOTMATCH): AnyNotMatchMatcher<T> = AnyNotMatchMatcher(this);

// String must have | start | end | contain
public fun String.must(val verb: HAVE): StringHaveMatcher = StringHaveMatcher(this)
public fun String.must(val verb: NOTHAVE): StringNotHaveMatcher = StringNotHaveMatcher(this)
public fun String.must(val verb: START): StringStartMatcher = StringStartMatcher(this)
public fun String.must(val verb: NOTSTART): StringNotStartMatcher = StringNotStartMatcher(this)
public fun String.must(val verb: END): StringEndMatcher = StringEndMatcher(this)
public fun String.must(val verb: NOTEND): StringNotEndMatcher = StringNotEndMatcher(this)
public fun String.must(val verb: CONTAIN): StringContainMatcher = StringContainMatcher(this)
public fun String.must(val verb: NOTCONTAIN): StringNotContainMatcher = StringNotContainMatcher(this)

// Number must be
public inline fun Number.must(val verb: BE): NumberBeMatcher = NumberBeMatcher(this)
public inline fun Number.must(val verb: NOTBE): NumberNotBeMatcher = NumberNotBeMatcher(this)


//() -> Unit must fail
public fun <T: () -> Any>T.must(verb: NOTFAIL): FunctionNotFailMatcher<T> = FunctionNotFailMatcher(this)
public fun <T: () -> Any>T.must(verb: FAIL): FunctionFailMatcher<T> = FunctionFailMatcher(this)

//Collection
public fun <T>Collection<T>.must(verb: CONTAIN): CollectionContainMatcher<T> = CollectionContainMatcher<T>(this)
public fun <T>Collection<T>.must(verb: NOTCONTAIN): CollectionNotContainMatcher<T> = CollectionNotContainMatcher<T>(this)
public fun <T>Collection<T>.must(verb: HAVE): CollectionHaveMatcher<T> = CollectionHaveMatcher<T>(this)
public fun <T>Collection<T>.must(verb: NOTHAVE): CollectionNotHaveMatcher<T> = CollectionNotHaveMatcher<T>(this)

//Map
public fun <K,V>Map<K,V>.must(verb: CONTAIN): MapContainMatcher<K,V> = MapContainMatcher<K,V>(this)
public fun <K,V>Map<K,V>.must(verb: NOTCONTAIN): MapNotContainMatcher<K,V> = MapNotContainMatcher<K,V>(this)
public fun <K,V>Map<K,V>.must(verb: HAVE): MapHaveMatcher<K,V> = MapHaveMatcher<K,V>(this)
public fun <K,V>Map<K,V>.must(verb: NOTHAVE): MapNotHaveMatcher<K,V> = MapNotHaveMatcher<K,V>(this)
