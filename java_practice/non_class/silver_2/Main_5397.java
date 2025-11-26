package silver_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5397 {
	
	/*
	 * BOJ_5397 : 키로거 (Silver_2)
	 * 자료구조 및 알고리즘 : 연결 리스트(Double Linked List)
	 *
	 * [문제 요약]
	 * - 비밀번호 창에서 입력한 키 로그(문자, <, >, -)가 주어진다.
	 * - '<', '>': 커서를 왼쪽/오른쪽으로 이동.
	 * - '-': 커서 앞의 글자를 삭제 (백스페이스).
	 * - 나머지: 해당 문자를 커서 위치에 삽입.
	 * - 최종적으로 만들어진 비밀번호를 출력하라.
	 *
	 * [핵심 아이디어]
	 * - 문자열의 길이가 최대 1,000,000이므로 배열을 이용한 중간 삽입/삭제(O(N))는 시간 초과 발생.
	 * - 삽입/삭제가 O(1)인 '연결 리스트'를 사용해야 한다.
	 * - Java의 기본 LinkedList나 Stack 2개를 사용하는 방법도 있지만, 
	 * Node 클래스를 직접 구현하는 것이 메모리와 시간 측면에서 가장 효율적이다.
	 *
	 * [구현 메모]
	 * - Dummy Node: 'Head'와 'Tail'이라는 빈 노드를 양 끝에 두어, 
	 * 맨 앞이나 맨 뒤에서의 삽입/삭제 시 null 체크를 하는 예외 처리를 제거했다.
	 * - pt (Pointer): 현재 커서의 위치(커서 바로 왼쪽 문자)를 가리키는 노드.
	 *
	 * [시간 복잡도]
	 * - 문자열 길이 L만큼 순회하며 O(1) 연산만 수행하므로 O(L).
	 */
	
	// 이중 연결 리스트를 위한 직접 구현 노드 클래스
	static class Key {
		char ch;
		Key prev, next;
		
		public Key(char ch) {
			this.ch = ch;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			char[] line = br.readLine().toCharArray();
			
			// 더미 헤드와 테일 생성 및 연결
			Key head = new Key(' '), tail = new Key(' ');
			head.next = tail; 
			tail.prev = head;
			
			// 초기 커서는 head(맨 앞)에 위치
			Key pt = head;
			
			for(char ch : line) {
				if(ch == '<') {
					// 왼쪽 이동: head가 아니라면 prev로 이동
					if(pt != head) pt = pt.prev; 
				}
				else if(ch == '>') {
					// 오른쪽 이동: 다음이 tail(끝)이 아니라면 next로 이동
					if(pt.next != tail) pt = pt.next;
				}
				else if(ch == '-') {
					// 삭제: head가 아니면 실행
					if(pt == head) continue;
					
					// 삭제 로직:
					// 1. 커서를 삭제할 노드의 이전(prev)으로 옮김
					// 2. 옮긴 위치에서 다다음 노드(next.next)를 연결하여 중간 노드(원래 pt) 삭제 효과
					pt = pt.prev;
					pt.next = pt.next.next;
					pt.next.prev = pt;
				} else {
					// 삽입: 새로운 노드 생성
					Key typed = new Key(ch);
					
					// 현재 pt와 pt.next 사이에 새 노드 연결
					typed.prev = pt;
					typed.next = pt.next;
					
					pt.next.prev = typed;
					pt.next = typed;
					
					// 커서를 새로 입력한 문자로 이동
					pt = typed;
				}
			}
			
			// 출력: head 다음부터 tail 전까지 순회
			pt = head.next;
			while(pt != tail) {
				sb.append(pt.ch);
				pt = pt.next;
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}