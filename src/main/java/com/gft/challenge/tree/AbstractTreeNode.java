package com.gft.challenge.tree;

import java.util.*;

abstract class AbstractTreeNode<T> implements TreeNode<T>, Iterable<T>{

    T thisNode;
    List<TreeNode<T>> children;

    AbstractTreeNode(T t) {
        thisNode = t;
        children = new ArrayList<>();
    }

    class AbstractTreeNodeIterator implements Iterator<T> {

        Queue<TreeNode<T>> queue = new LinkedList<>();

        AbstractTreeNodeIterator(AbstractTreeNode<T> node) {
            queue.add(node);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            TreeNode<T> node = queue.remove();
            queue.addAll(node.getChildrenCollection());
            return node.get();
        }
    }
}
