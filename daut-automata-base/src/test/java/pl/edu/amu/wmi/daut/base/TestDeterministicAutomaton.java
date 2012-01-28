package pl.edu.amu.wmi.daut.base;

import junit.framework.TestCase;

/**
 * Test klasy DeterministicAutomaton.
 * Automat deterministyczny VII
 * Automat: automat deterministyczny akceptujacy wszystkie napisy zlozone ze znaku 'a', których dlugosc dzieli sie przez 2 lub 3.
 * Co przetestowac: metoda accepts klasy DeterministicAutomaton.
 * v1.4
 */
public class TestDeterministicAutomaton extends TestCase {
    /**
     * Symulacja testu.
     */
    public final void testFirstOne() {

        final AutomatonSpecification spec = new NaiveAutomatonSpecification();
		/**
		*Stany
		*/
        State q0a = spec.addState();
        State q1a = spec.addState();
        State q2a = spec.addState();
        State q3a = spec.addState();
        State q4a = spec.addState();
        State q5a = spec.addState();
        State q6a = spec.addState();
		/**
		*Kolejne reprezentacje liczb podzielnych przez 1,2,3,4,5,6
		*/
        spec.addTransition(q0a, q1a, new CharTransitionLabel('a'));
        spec.addTransition(q1a, q2a, new CharTransitionLabel('a'));
        spec.addTransition(q2a, q3a, new CharTransitionLabel('a'));
        spec.addTransition(q3a, q4a, new CharTransitionLabel('a'));
        spec.addTransition(q4a, q5a, new CharTransitionLabel('a'));
        spec.addTransition(q5a, q6a, new CharTransitionLabel('a'));
        spec.addTransition(q6a, q1a, new CharTransitionLabel('a'));

        spec.markAsInitial(q0a);
		/**
		*podzielne przez 2, 3, 4 i 6)
		*/
        spec.markAsFinal(q0a);
        spec.markAsFinal(q2a);
        spec.markAsFinal(q3a);
        spec.markAsFinal(q4a);
        spec.markAsFinal(q6a);

        final DeterministicAutomaton automaton = new DeterministicAutomaton(spec);

		/**
		*Prawdziwe
		*/

		assertTrue(automaton.accepts("aaaaaaaaaa"));
		assertTrue(automaton.accepts("aaaaaaaaa"));
		assertTrue(automaton.accepts("aaaaaaaa"));	
		assertTrue(automaton.accepts("aaaaaa"));
        	assertTrue(automaton.accepts("aaaa"));
        	assertTrue(automaton.accepts("aaa"));
        	assertTrue(automaton.accepts("aa"));
        	assertTrue(automaton.accepts(""));
		
		/**
		*Falszywe
		*/	

        	assertFalse(automaton.accepts("aaaaaaaaaaaaa"));
        	assertFalse(automaton.accepts("aaaaaaaaaaa"));
		assertFalse(automaton.accepts("aaaaaaa"));
        	assertFalse(automaton.accepts("aaaaa"));
		assertFalse(automaton.accepts("a"));
    						}
								}
