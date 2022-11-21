# Pull Request 보내는 방법

## 1. PR 보낼 저장소 fork

- PR을 보내고자 하는 저장소를 자신의 저장소로 fork한다.

![Pasted image 20221121105924](https://user-images.githubusercontent.com/70932170/203032871-b38a17de-fa1f-48c0-a8e2-d458aa18e605.png)

---

![Pasted image 20221121110222](https://user-images.githubusercontent.com/70932170/203033030-22562115-60ea-4e0a-95d7-7bf6dd02f70b.png)

---

- fork한 저장소 확인

![Pasted image 20221121110355](https://user-images.githubusercontent.com/70932170/203033423-80842a88-ebc3-4260-9954-91f838cbfe2c.png)

## 2. 내 컴퓨터에 저장소 clone

- fork한 저장소를 clone 해오기

```bash
$ git clone https://github.com/YOUR_FORK_USERNAME/YOUR_FORK.git
```

- 예시

![Pasted image 20221121111307](https://user-images.githubusercontent.com/70932170/203033565-3d4f2d42-d279-40c4-bb3d-ad69878be078.png)

```bash
$ git clone https://github.com/Hyyena/Coding-Test-Study.git
```

## 3. 원격 저장소 remote 설정

> fork한 저장소를 **원격 저장소의 최신 커밋**으로 내용을 변경하기 위해 remote 설정

- clone 한 저장소에 원격 저장소 설정하기 *(PR 보낼 저장소를 추가하는 것)*
- 원격 저장소 git 주소는 **PR 보낼 저장소**
- 원격 저장소의 이름을 `upstream`으로 설정

```bash
$ git remote add upstream https://github.com/ORIGIN_OWNER/ORIGIN_REPO.git
```

- 예시

```bash
$ git remote add upstream https://github.com/Coding-Test-Study-Group/Coding-Test-Study.git
```

## 4. 설정 확인

- `git remote -v` 명령어로 아래와 같이 설정되었는지 확인

```bash
$ git remote -v
> origin    https://github.com/YOUR_USERNAME/YOUR_FORK.git (fetch)
> origin    https://github.com/YOUR_USERNAME/YOUR_FORK.git (push)
> upstream  https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git (fetch)
> upstream  https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git (push)
```

- 예시

```bash
$ git remote -v
> origin    https://github.com/Hyyena/Coding-Test-Study.git (fetch)
> origin    https://github.com/Hyyena/Coding-Test-Study.git (push)
> upstream  https://github.com/Coding-Test-Study-Group/Coding-Test-Study.git (fetch)
> upstream  https://github.com/Coding-Test-Study-Group/Coding-Test-Study.git (push)
```

## 5. PR용 branch 생성

- clone 해 온 저장소의 기본 branch는 `main`
- 코드를 수정하고, PR을 보낼 용도로 사용할 **새로운 branch 생성**

```bash
$ git checkout -b 브랜치명
```

- 위 명령어를 통해 branch를 만들면 현재 branch에서 새로 만든 branch로 변경됨

## 6. 코드 수정

- 위에서 생성한 branch로 코드 수정 후 아래 명령어를 통해 `git add & commit`

```bash
$ git add .
$ git commit -m "커밋메시지는 정해진 규칙에 맞추어 작성"
```

- VSCode의 Source Control 등을 이용해도 무방

## 7. PR용 branch에 push

- 위에서 생성한 branch로 fork해 온 저장소에 `push` 하기

```bash
$ git push origin 브랜치명
```

## 8. github에서 fork한 저장소 확인

- github에서 fork해 온 저장소를 들어간 후 아래와 같이 `Compare & pull request` 버튼이 활성화 된 것을 확인

![Pasted image 20221121171135](https://user-images.githubusercontent.com/70932170/203033845-5d32fa11-5499-4c3e-83fa-0bfae6fd58bd.png)

- 버튼을 누르면 아래와 같이 PR 양식이 뜹니다.

![Pasted image 20221121172515](https://user-images.githubusercontent.com/70932170/203033865-8ecfef19-71a2-44a0-a6ef-68f780bd910d.png)

- PR 양식에 맞추어 내용 작성 후 `Create pull request` 버튼을 눌러 PR을 보낸다.
- 원본 저장소에서 PR이 승인되면 `merge`가 이루어진다.

<details>
<summary>
❗Create pull request 버튼 안 뜰 시
</summary>

![Pasted image 20221121182911](https://user-images.githubusercontent.com/70932170/203033925-d9718669-1d09-4188-bbbe-ecf7cdfd6dd2.png)

- fork한 저장소에서 branch를 작업 branch로 변경

![Pasted image 20221121182059](https://user-images.githubusercontent.com/70932170/203033939-8ae0ba03-bd80-46fb-b13f-8fa08e645bd7.png)

- fork한 저장소에서 아래와 같이 `New pull request` 버튼을 눌러 PR 생성

![Pasted image 20221121181852](https://user-images.githubusercontent.com/70932170/203033961-ffdafa40-fa76-4346-865a-022974813bab.png)

- 작업용 branch에서 원본 저장소의 `main` branch로 PR을 보낸다.

> ex) 작업을 진행한 Hyyena/Coding-Test-Study add-docs 브랜치에서 Coding-Test-Study-Group main 브랜치로 Pull Request

</details>

## 9. PR 승인 후 동기화 및 branch 삭제

- PR이 승인되어 원본 저장소에 `merge`가 되었다면, 작업이 끝난 branch는 삭제해도 된다.
- 아래 명령어로 원본 저장소와 로컬 저장소의 코드를 동기화

```bash
$ git pull upstream main
```

- 아래 명령어는 각각 local과 remote branch를 삭제하는 명령어

```bash
$ git branch -D branch_name
$ git push origin :branch_name (혹은 git push origin --delete branch_name)
```
