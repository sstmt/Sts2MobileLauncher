<div align="right">
  <strong><a href="README.md">🇺🇸 English</a></strong> ·
  <strong><a href="README_CN.md">🇨🇳 简体中文</a></strong>
</div>

<h1 align="center">Slay the Spire 2 Android ランチャー（日本語対応版）</h1>

*Slay the Spire 2* の PC 版を Android 端末で動かすための、非公式・実験的なランチャーです。**ゲーム本体のファイルは一切含みません。** 自分が正規に所有している PC 版を取り込んで使います。

詳しい仕組みやビルド手順は [README.md](README.md)（英語）と [`doc/`](doc/README.md)（中国語）を参照してください。

## 日本語対応について

- 端末の言語が日本語のとき、ランチャーの画面（設定、MOD、バージョン管理、Steam、ワークショップ、WebDAV、ログ、クラッシュ画面など）が日本語で表示されます。英語・中国語の表示は従来どおりです。
- ログの LLM 分析は、日本語環境では日本語で回答するよう指示します。
- 進行状況の一部メッセージ（Steam / WebDAV の同期中表示など）は英語のままです。
- ゲーム内の言語は、ゲーム本体の設定に従います。

## 日本語環境での既定動作

| 項目 | 動作 |
| --- | --- |
| ワークショップの「互換アクセス」 | 既定でオフ。第三者の中継サーバー（`rmbgame.net`）を経由する機能で、Steam に直接つながる環境では不要です。必要ならワークショップの設定でオンにできます。 |
| ネットワークドライブ経由のゲーム入手リンク | 表示しません。ゲーム本体は、自分の Steam アカウントでのダウンロードか、自分の PC 版の zip 取り込みで用意してください。 |
| release ビルドの `debuggable` | 既定でオフ。`run-as` でアプリ内のデータ（Steam トークンやセーブ）を読めません。 |

## 使い方

1. APK をインストールして起動します。
2. 初回ウィザードで、PC 版の `SlayTheSpire2.zip`（RAR / 7z なども可）を取り込むか、Steam にログインしてゲーム本体をダウンロードします。
3. 「バージョン」ページで、ゲームのバージョンに合った互換パックが選ばれていることを確認します。
4. 「起動」を押します。

## 安全上の注意

- **MOD は任意のコードを実行できます。** 悪意のある MOD は、アプリ内に保存された Steam のログイン情報やセーブデータを読み取れます。信頼できる配布元の MOD だけを入れてください。出どころの不明な MOD を試す前に、Steam からログアウトしてください。
- **Steam にログインするなら**、自分でビルドした APK か、信頼できる入手元の APK を使い、Steam Guard を有効にしてください。パスワードと Guard コードは保存されず、refresh token は端末内に暗号化して保存されます。
- **WebDAV と LLM のアドレスは `https://` を使ってください。** `http://` ではパスワードやログが暗号化されずに送信されます。
- **Spire Supply Station**（ワークショップの代替ダウンロード、既定でオフ）は第三者のサービスです。オンにすると MOD の入手元がそのサービスになります。

## ビルド

```bash
cp .env.example .env
cp local.properties.example local.properties
# .env に JDK / Android SDK / ランタイム参照などを設定
tools/package/build_importer_apk.sh
```

出力は `dist/sts2-re-importer.apk` です。`adb` の `run-as` を使う検証用ビルドは `tools/debug/sts2-adb-debug.sh build` で作れます。

## 免責事項

本プロジェクトはコミュニティによる非公式の技術研究であり、Mega Crit、*Slay the Spire 2*、Godot Engine とは関係ありません。利用には PC 版 *Slay the Spire 2* を正規に所有している必要があります。ゲームの素材を同梱した APK を配布しないでください。
