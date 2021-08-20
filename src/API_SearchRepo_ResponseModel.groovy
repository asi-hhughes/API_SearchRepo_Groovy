import groovy.json.JsonSlurper as JsonSlurper
import groovy.test.GroovyTestCase

class ModelTest extends GroovyTestCase {

    def tools = new GroovyScriptEngine('src').with{
        loadScriptByName('API_SearchRepo_Tools.groovy')
    }

    //Verify response model (no signature breaks)
    void testResponseModelUnchanged() {
        def conn = tools.createConnection()

        def responseText = conn.getInputStream().text
        def responseJson = new JsonSlurper().parseText(responseText)

        //Verify model
        assert responseJson.containsKey('total_count')
        assert responseJson.containsKey('incomplete_results')
        assert responseJson.containsKey('items')
        assert responseJson.items[0].containsKey('id')
        assert responseJson.items[0].containsKey('node_id')
        assert responseJson.items[0].containsKey('name')
        assert responseJson.items[0].containsKey('full_name')
        assert responseJson.items[0].containsKey('owner')
        assert responseJson.items[0].owner.containsKey('login')
        assert responseJson.items[0].owner.containsKey('id')
        assert responseJson.items[0].owner.containsKey('node_id')
        assert responseJson.items[0].owner.containsKey('avatar_url')
        assert responseJson.items[0].owner.containsKey('gravatar_id')
        assert responseJson.items[0].owner.containsKey('url')
        assert responseJson.items[0].owner.containsKey('received_events_url')
        assert responseJson.items[0].owner.containsKey('type')
        assert responseJson.items[0].owner.containsKey('html_url')
        assert responseJson.items[0].owner.containsKey('followers_url')
        assert responseJson.items[0].owner.containsKey('following_url')
        assert responseJson.items[0].owner.containsKey('gists_url')
        assert responseJson.items[0].owner.containsKey('starred_url')
        assert responseJson.items[0].owner.containsKey('subscriptions_url')
        assert responseJson.items[0].owner.containsKey('organizations_url')
        assert responseJson.items[0].owner.containsKey('repos_url')
        assert responseJson.items[0].owner.containsKey('events_url')
        assert responseJson.items[0].owner.containsKey('site_admin')
        assert responseJson.items[0].containsKey('private')
        assert responseJson.items[0].containsKey('html_url')
        assert responseJson.items[0].containsKey('description')
        assert responseJson.items[0].containsKey('fork')
        assert responseJson.items[0].containsKey('url')
        assert responseJson.items[0].containsKey('created_at')
        assert responseJson.items[0].containsKey('updated_at')
        assert responseJson.items[0].containsKey('pushed_at')
        assert responseJson.items[0].containsKey('homepage')
        assert responseJson.items[0].containsKey('size')
        assert responseJson.items[0].containsKey('stargazers_count')
        assert responseJson.items[0].containsKey('watchers_count')
        assert responseJson.items[0].containsKey('language')
        assert responseJson.items[0].containsKey('forks_count')
        assert responseJson.items[0].containsKey('open_issues_count')
        assert responseJson.items[0].containsKey('default_branch')
        assert responseJson.items[0].containsKey('score')
        assert responseJson.items[0].containsKey('archive_url')
        assert responseJson.items[0].containsKey('assignees_url')
        assert responseJson.items[0].containsKey('blobs_url')
        assert responseJson.items[0].containsKey('branches_url')
        assert responseJson.items[0].containsKey('collaborators_url')
        assert responseJson.items[0].containsKey('comments_url')
        assert responseJson.items[0].containsKey('commits_url')
        assert responseJson.items[0].containsKey('compare_url')
        assert responseJson.items[0].containsKey('contents_url')
        assert responseJson.items[0].containsKey('contributors_url')
        assert responseJson.items[0].containsKey('deployments_url')
        assert responseJson.items[0].containsKey('downloads_url')
        assert responseJson.items[0].containsKey('events_url')
        assert responseJson.items[0].containsKey('forks_url')
        assert responseJson.items[0].containsKey('git_commits_url')
        assert responseJson.items[0].containsKey('git_refs_url')
        assert responseJson.items[0].containsKey('git_tags_url')
        assert responseJson.items[0].containsKey('git_url')
        assert responseJson.items[0].containsKey('issue_comment_url')
        assert responseJson.items[0].containsKey('issue_events_url')
        assert responseJson.items[0].containsKey('issues_url')
        assert responseJson.items[0].containsKey('keys_url')
        assert responseJson.items[0].containsKey('labels_url')
        assert responseJson.items[0].containsKey('languages_url')
        assert responseJson.items[0].containsKey('merges_url')
        assert responseJson.items[0].containsKey('milestones_url')
        assert responseJson.items[0].containsKey('notifications_url')
        assert responseJson.items[0].containsKey('pulls_url')
        assert responseJson.items[0].containsKey('releases_url')
        assert responseJson.items[0].containsKey('ssh_url')
        assert responseJson.items[0].containsKey('stargazers_url')
        assert responseJson.items[0].containsKey('statuses_url')
        assert responseJson.items[0].containsKey('subscribers_url')
        assert responseJson.items[0].containsKey('subscription_url')
        assert responseJson.items[0].containsKey('tags_url')
        assert responseJson.items[0].containsKey('teams_url')
        assert responseJson.items[0].containsKey('trees_url')
        assert responseJson.items[0].containsKey('clone_url')
        assert responseJson.items[0].containsKey('mirror_url')
        assert responseJson.items[0].containsKey('hooks_url')
        assert responseJson.items[0].containsKey('svn_url')
        assert responseJson.items[0].containsKey('forks')
        assert responseJson.items[0].containsKey('open_issues')
        assert responseJson.items[0].containsKey('watchers')
        assert responseJson.items[0].containsKey('has_issues')
        assert responseJson.items[0].containsKey('has_projects')
        assert responseJson.items[0].containsKey('has_pages')
        assert responseJson.items[0].containsKey('has_wiki')
        assert responseJson.items[0].containsKey('has_downloads')
        assert responseJson.items[0].containsKey('archived')
        assert responseJson.items[0].containsKey('disabled')
        assert responseJson.items[0].containsKey('license')
        assert responseJson.items[0].license.containsKey('key')
        assert responseJson.items[0].license.containsKey('name')
        assert responseJson.items[0].license.containsKey('url')
        assert responseJson.items[0].license.containsKey('spdx_id')
        assert responseJson.items[0].license.containsKey('node_id')
        }

/*
Github's documentation lists the following two keys in their example response, but neither exists.  Time to write a defect report!
assert slurpedResponse.items[0].license.containsKey('html_url')
assert slurpedResponse.items[0].containsKey('master_branch')
 */

}