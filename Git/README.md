# What is Git
TODO

# Commands

### Clone a repository
```
git clone <url>
```

### Status
```
git status
```

### Pull
```
git pull
```

### Add
```
git add <myfile.txt>
```

### Git Reset
git reset is used to "un-add" a file. 
```
git reset <myfile.txt>
```

### Commit
```
git commit
```

### Push
```
git push
```

### Get difference from last commit
```
git diff <myfile.txt>
```

### Show commit logs
```
git log
```

### Branch
```
git branch <feature_branch>
```

### Show all branches
```
git branch -a
```

### Change branch
```
git checkout <branch>
```

### Rebase
```
git rebase 
```

### Remove commits in Pull Request
```
$ git checkout my-branch
$ git log  # find the commit to revert to
$ git rebase -i commit-hash. # interactive rebase
# Replace "pick" with "drop" for commits to remove
$ git push origin my-branch --force
```
