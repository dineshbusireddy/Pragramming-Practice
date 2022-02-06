package com.programming.practice.leetcode;

import com.programming.practice.domain.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MergeTwoSortedListsTest {

    @InjectMocks
    private MergeTwoSortedLists mergeTwoSortedLists;

    private static Stream<Arguments> testMergeTwoLists() {
        return Stream.of(
               Arguments.of(new ListNode(1).addLast(2).addLast(4),
                        new ListNode(1).addLast(3).addLast(4),
                        "[1, 1, 2, 3, 4, 4]"),
                Arguments.of(new ListNode(1).addLast(3).addLast(6).addLast(8),
                        new ListNode(2).addLast(4),
                        "[1, 2, 3, 4, 6, 8]"),
                Arguments.of(new ListNode(1),
                        new ListNode(2).addLast(3).addLast(4).addLast(5).addLast(6),
                        "[1, 2, 3, 4, 5, 6]"),
                Arguments.of(null,
                        null, "[]"),
                Arguments.of(null,
                        new ListNode(0), "[0]")
        );
    }

    @ParameterizedTest
    @MethodSource("testMergeTwoLists")
    void executeTests(ListNode l1, ListNode l2, String expected) {
        assertEquals(expected, getActualAsString(mergeTwoSortedLists.mergeTwoLists(l1, l2)));
    }

    private String getActualAsString(ListNode output) {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        ListNode current = output;
        while (current != null) {
            result.add(current.val + "");
            current = current.next;
        }
        return result.toString();
    }
}