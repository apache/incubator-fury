from libcpp.utility cimport pair

# Copied from https://github.com/messense/cython-abseil-sample/blob/master/absl.pxd
cdef extern from "absl/container/flat_hash_map.h" namespace "absl" nogil:
    cdef cppclass flat_hash_map[T, U]:
        ctypedef T key_type
        ctypedef U mapped_type
        ctypedef pair[const T, U] value_type
        cppclass iterator:
            pair[T, U]& operator*()
            iterator operator++()
            iterator operator--()
            bint operator==(iterator)
            bint operator!=(iterator)
        cppclass reverse_iterator:
            pair[T, U]& operator*()
            iterator operator++()
            iterator operator--()
            bint operator==(reverse_iterator)
            bint operator!=(reverse_iterator)
        cppclass const_iterator(iterator):
            pass
        cppclass const_reverse_iterator(reverse_iterator):
            pass
        flat_hash_map() except +
        flat_hash_map(flat_hash_map&) except +
        # flat_hash_map(key_compare&)
        U& operator[](T&)
        # flat_hash_map& operator=(flat_hash_map&)
        bint operator==(flat_hash_map&, flat_hash_map&)
        bint operator!=(flat_hash_map&, flat_hash_map&)
        bint operator<(flat_hash_map&, flat_hash_map&)
        bint operator>(flat_hash_map&, flat_hash_map&)
        bint operator<=(flat_hash_map&, flat_hash_map&)
        bint operator>=(flat_hash_map&, flat_hash_map&)
        U& at(const T&)
        const U& const_at "at"(const T&)
        iterator begin()
        const_iterator const_begin "begin"()
        void clear()
        size_t count(T&)
        bint empty()
        iterator end()
        const_iterator const_end "end"()
        pair[iterator, iterator] equal_range(T&)
        pair[const_iterator, const_iterator] const_equal_range "equal_range"(const T&)
        void erase(iterator)
        void erase(iterator, iterator)
        size_t erase(T&)
        iterator find(T&)
        const_iterator const_find "find"(T&)
        pair[iterator, bint] insert(pair[T, U])  # XXX pair[T,U]&
        iterator insert(iterator, pair[T, U])  # XXX pair[T,U]&
        iterator insert(iterator, iterator)
        # key_compare key_comp()
        iterator lower_bound(T&)
        const_iterator const_lower_bound "lower_bound"(T&)
        size_t max_size()
        reverse_iterator rbegin()
        const_reverse_iterator const_rbegin "rbegin"()
        reverse_iterator rend()
        const_reverse_iterator const_rend "rend"()
        size_t size()
        void swap(flat_hash_map&)
        iterator upper_bound(T&)
        const_iterator const_upper_bound "upper_bound"(T&)
        # value_compare value_comp()
        void max_load_factor(float)
        float max_load_factor()
        void rehash(size_t)
        void reserve(size_t)
        size_t bucket_count()
        size_t max_bucket_count()
        size_t bucket_size(size_t)
        size_t bucket(const T&)
