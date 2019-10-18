# Umamee

Hello and welcome Chef!

## Git Usage

This section describes how branches should be used for Umamee development.

### Main Branches

The `master` branch is used for releases and requires a pull request in order to merge changes. Releases are tagged with a version number when ready.

The `develop` branch contains the latest delivered development changes which will be rolled into the next release.

### Feature Branches

Create `feature/*` branches for new features. These must branch off `develop` and  merge back into `develop`. To create a new branch:
```
git checkout -b feature/my-feature develop
```
To merge a finished feature back into `develop` branch, first checkout the `develop` branch and update it to the latest version.
```
git checkout develop
git pull
```
Next, merge your feature branch into the `develop` branch, delete the `feature/*` branch and push your changes. (Note: use the `--no-ff` flag in order to force a new commit object)
```
git merge --no-ff feature/my-feature
git push origin develop
git push origin feature/my-feature
git branch -d feature/my-feature
```

### Release Branches

Create `release/*` branches in preparation for a releases. These should branch off `develop` and merge into `master` and (optionally) `develop`.
```
git checkout -b release/X.Y.0 develop
<<< Make some changes>>>
git commit -a -m "Last minute changes for release"
```
When ready, merge into `master`:
```
git checkout master
git merge --no-ff release/X.Y.0
git tag -a X.Y.0
```
If necessary, merge changes into `develop` as well:
```
git checkout develop
git merge --no-ff release/X.Y.0
```
Finally, delete the branch.
```
git branch -d release/X.Y.0
```

### Hotfix Branches
Contain high-priority fixes that affect a release. Branch off `master` and merge into `develop` and `master`.
```
git checkout -b hotfix/my-hotfix master
<<<Make some changes>>>
git commit -a -m "Fixed issue affecting release"
```
When ready, merge back into `master` and create a tag.
```
git checkout master
git merge --no-ff hotfix/my-hotfix
git tag -a X.Y.Z
```
Merge into `develop` as well, so that the fix makes it into the next release.
```
git checkout develop
git merge --no-ff hotfix/my-hotfix
```
Finally, delete the branch.
```
git branch -d hotfix/my-hotfix
```

## Suggestions         

- mobile android app 
- Data Bases mySQL
- Recipe database - cookbook
- User data - pantry 
- User data - grocery list

                         
## Key Features        


- User DB
- Recipe DB
- Camera algorithm
- Querying algorithm
- Machine Learning algorithm for suggested recipies
- Timer algorithms for food depreciation
- Front end work
- Suggested youtube video plugin



## Meetings 

- Wednesday 8:00
- Sunday 8:00


## Benchmarking

- Facebook
- Uber
- Youtube
- GroupMe
- WhatsApp
- Venmo
- Twitch
- SnapChat
