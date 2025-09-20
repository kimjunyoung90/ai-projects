# AI Code Generation 비교 프로젝트

동일한 프롬프트에 대한 Codex, Claude, Gemini 3개 AI 모델의 코드 생성 결과를 비교하는 실험 프로젝트입니다.

## 📋 프로젝트 구조

```
ai-project/
├── codex-todo/    # GitHub Copilot Codex 결과
├── claude-todo/   # Claude Code 결과
├── gemini-todo/   # Gemini CLI 결과
└── README.md
```

## 📝 프롬프트

### 1단계. 투두 리스트 CRUD 서버 개발 (Spring Boot + JPA + H2)
```
# 역할
너는 숙련된 백엔드 개발자야. 내가 요청한 기능에 맞게 java + Spring Boot 기반의 코드를 작성해줘.

# 기술 스택
Spring Boot 3.x, Spring Web, Spring Data JPA, H2DB

# 요구사항
1. Todo Entity는 title, description, isDone 필드를 갖는다.
2. title은 필수이며, description은 선택, isDone은 기본값 false.
3. 투두를 등록(Create), 전체 조회(Read), 단건 조회(Read), 수정(Update), 삭제(Delete)하는 REST API를 만들어줘.
4. 각 기능에 맞는 DTO, Service, Controller를 작성해줘.
5. Repository는 JpaRepository로 만들어줘.
6. 테스트 코드는 나중에 따로 요청할게.
```

### 2단계. Thymeleaf + HTML로 간단한 프론트엔드 개발
```
# 역할
너는 Spring Boot + Thymeleaf를 사용하는 웹 프론트엔드 개발자야.
기존 작성된 서버 코드를 바탕으로 Thymeleaf와 연동을 진행해주면 돼

# 요구사항
1. todo 목록을 보여주는 list.html을 만들어줘.
2. todo 등록 폼을 갖는 create.html을 만들어줘.
3. 등록 폼에는 title, description 입력창과 등록 버튼이 있어야 해.
4. 목록 페이지에서는 체크박스로 완료 처리(isDone 수정)가 가능해야 해.
5. Controller는 @Controller 애노테이션을 사용하고, Model에 데이터 넣어서 view에 전달해줘.
6. thymeleaf 문법은 기본적인 것만 사용해줘.
```

## 🚀 실행 방법

각 디렉토리별로 독립 실행:
```bash
cd codex-todo && ./mvnw spring-boot:run    # 포트 8080
cd claude-todo && ./mvnw spring-boot:run   # 포트 8081
cd gemini-todo && ./mvnw spring-boot:run   # 포트 8082
```